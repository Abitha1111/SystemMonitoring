package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net"
	"os/exec"
	"strings"
	"time"

	"github.com/gorilla/websocket"
	"github.com/shirou/gopsutil/v3/cpu"
	"github.com/shirou/gopsutil/v3/disk"
	"github.com/shirou/gopsutil/v3/host"
	"github.com/shirou/gopsutil/v3/mem"
	gopsutilnet "github.com/shirou/gopsutil/v3/net"
	"github.com/shirou/gopsutil/v3/process"
)

type SystemInfo struct {
	Hostname       string  `json:"hostname"`
	IP             string  `json:"ip"`
	CPUModel       string  `json:"cpu_model"`
	TotalMemory    string  `json:"total_memory"`
	UsedMemory     string  `json:"used_memory"`
	Uptime         string  `json:"uptime"`
	WiFi           string  `json:"wifi"`
	Battery        string  `json:"battery"`
	SSHInfo        string  `json:"ssh_info"`
	Timestamp      string  `json:"timestamp"`
	FreeMemory     uint64  `json:"free_memory"`
	CPULoad        float64 `json:"cpu_load"`
	SwapTotal      uint64  `json:"swap_total"`
	SwapUsed       uint64  `json:"swap_used"`
	DiskTotal      uint64  `json:"disk_total"`
	DiskUsed       uint64  `json:"disk_used"`
	DiskFree       uint64  `json:"disk_free"`
	NetworkRxBytes uint64  `json:"network_rx_bytes"`
	NetworkTxBytes uint64  `json:"network_tx_bytes"`
	NetworkSpeed   string  `json:"network_speed"`
	Temperature    string  `json:"temperature"`
	ProcessCount   string  `json:"process_count"`
}

type SystemInfoWrapper struct {
	System1Info SystemInfo `json:"Kalpana_Info"`
}

func getCPUModel() (string, error) {
	cpuInfo, err := cpu.Info()
	if err != nil {
		return "", err
	}
	if len(cpuInfo) > 0 {
		return cpuInfo[0].ModelName, nil
	}
	return "Unknown", nil
}

func getMemoryInfo() (string, string, error) {
	vmStat, err := mem.VirtualMemory()
	if err != nil {
		return "", "", err
	}
	totalMem := fmt.Sprintf("%.2f GB", float64(vmStat.Total)/(1024*1024*1024))
	usedMem := fmt.Sprintf("%.2f GB (%.2f%%)", float64(vmStat.Used)/(1024*1024*1024), vmStat.UsedPercent)
	return totalMem, usedMem, nil
}

func getUptime() (string, error) {
	uptime, err := host.Uptime()
	if err != nil {
		return "", err
	}
	uptimeDuration := time.Duration(uptime) * time.Second
	return uptimeDuration.String(), nil
}

func getWiFiInfo() (string, error) {
	out, err := exec.Command("iwconfig").Output()
	if err != nil {
		return "", fmt.Errorf("WiFi information command not found")
	}
	wifiInfo := string(out)
	//if strings.Contains(wifiInfo, "ESSID") {
	lines := strings.Split(wifiInfo, "\n")
	for _, line := range lines {
		if strings.Contains(line, "ESSID") {
			return line, nil
		}
	}
	//}
	return "No WiFi info available", nil
}

func getBatteryInfo() (string, error) {
	out, err := exec.Command("upower", "-i", "/org/freedesktop/UPower/devices/battery_BAT0").Output()
	if err != nil {
		return "", fmt.Errorf("Battery information command not found")
	}

	lines := strings.Split(string(out), "\n")
	var batteryInfo []string
	var state, timeToEmpty, timeToFull, percentage string

	for _, line := range lines {
		line = strings.TrimSpace(line) // Clean up whitespace
		if strings.Contains(line, "state") {
			state = strings.ReplaceAll(line, " ", "") // Remove spaces
		} else if strings.Contains(line, "time to empty") {
			timeToEmpty = strings.TrimSpace(line)
		} else if strings.Contains(line, "time to full") {
			timeToFull = strings.TrimSpace(line)
		} else if strings.Contains(line, "percentage") {
			percentage = strings.ReplaceAll(line, " ", "") // Remove spaces
		}
	}

	batteryInfo = append(batteryInfo, state)
	if timeToFull != "" {
		batteryInfo = append(batteryInfo, timeToFull)
	} else if timeToEmpty != "" {
		batteryInfo = append(batteryInfo, timeToEmpty)
	}
	if percentage != "" {
		batteryInfo = append(batteryInfo, percentage)
	}

	if len(batteryInfo) > 0 {
		return strings.Join(batteryInfo, ", "), nil
	}
	return "No Battery info available", nil
}

func getSSHInfo() (string, error) {
	out, err := exec.Command("ss", "-tuna").Output()
	if err != nil {
		return "", fmt.Errorf("SSH command not found")
	}

	ssOut := string(out)
	var connectedIPs []string
	lines := strings.Split(ssOut, "\n")

	for _, line := range lines {
		if strings.Contains(line, ":22") && strings.Contains(line, "ESTAB") {
			parts := strings.Fields(line)
			if len(parts) >= 5 {
				remoteAddress := parts[len(parts)-1]
				ip := strings.Split(remoteAddress, ":")[0]
				if ip != "127.0.0.1" && ip != "localhost" {
					connectedIPs = append(connectedIPs, ip)
				}
			}
		}
	}

	if len(connectedIPs) > 0 {
		return fmt.Sprintf("Active SSH connections detected. Connected IPs: %s", strings.Join(connectedIPs, ", ")), nil
	}
	return "No active SSH connections", nil
}

// Function to get the system IP address
func getIPAddress() (string, error) {
	interfaces, err := net.Interfaces()
	if err != nil {
		return "", err
	}

	for _, iface := range interfaces {
		if iface.Flags&net.FlagUp != 0 && iface.Flags&net.FlagLoopback == 0 {
			addrs, err := iface.Addrs()
			if err != nil {
				return "", err
			}
			for _, addr := range addrs {
				var ip net.IP
				switch v := addr.(type) {
				case *net.IPNet:
					ip = v.IP
				case *net.IPAddr:
					ip = v.IP
				}
				if ip != nil && ip.To4() != nil {
					return ip.String(), nil
				}
			}
		}
	}
	return "No IP address found", nil
}

func getCPULoad() (float64, error) {
	// Get the CPU percentage, averaged over all cores, for a duration of 1 second
	percentages, err := cpu.Percent(1*time.Second, false)
	if err != nil {
		return 0, err
	}
	// Return the first element which represents the total CPU usage
	if len(percentages) > 0 {
		return percentages[0], nil
	}
	return 0, nil
}

func getFreeMemory() (uint64, error) {
	v, err := mem.VirtualMemory()
	if err != nil {
		return 0, err
	}
	return v.Available, nil
}

func getSwapInfo() (uint64, uint64, error) {
	swap, err := mem.SwapMemory()
	if err != nil {
		return 0, 0, err
	}
	return swap.Total, swap.Used, nil
}

func getDiskInfo() (uint64, uint64, uint64, error) {
	usage, err := disk.Usage("/")
	if err != nil {
		return 0, 0, 0, err
	}
	return usage.Total, usage.Used, usage.Free, nil
}

func getNetworkInfo() (uint64, uint64, error) {
	netStats, err := gopsutilnet.IOCounters(false) // Use the new import alias
	if err != nil {
		return 0, 0, err
	}
	if len(netStats) > 0 {
		// Assuming you want to get the first network interface stats
		return netStats[0].BytesRecv, netStats[0].BytesSent, nil
	}
	return 0, 0, fmt.Errorf("no network stats available")
}

func getProcessCount() (string, error) {
	procs, err := process.Processes()
	if err != nil {
		return "", err
	}
	return fmt.Sprintf("%d", len(procs)), nil
}

// Function to get system temperature
// func getTemperature() (string, error) {
// 	temps, err := temperature.Sensors()
// 	if err != nil {
// 		return "", err
// 	}
// 	if len(temps) > 0 {
// 		return fmt.Sprintf("%.2f°C", temps[0].Temperature), nil
// 	}
// 	return "Unknown", nil
// }

func getTemperature() (string, error) {
	// Replace with the correct path to your temperature sensor
	data, err := ioutil.ReadFile("/sys/class/thermal/thermal_zone0/temp")
	if err != nil {
		return "", err
	}

	// Convert data to a string
	return string(data), nil
}

// Function to get network speed (dummy implementation for now)
func getNetworkSpeed() (string, error) {
	// Implement real network speed detection if possible
	return "Wi-Fi (150 Mbps)", nil // Example return
}

func main() {
	// WebSocket connection setup
	wsURL := "ws://192.168.79.196:8080/SystemMonitoring/serverws" // Replace with your actual WebSocket server URL
	conn, _, err := websocket.DefaultDialer.Dial(wsURL, nil)
	if err != nil {
		log.Fatal("Error connecting to WebSocket:", err)
	}
	defer conn.Close()

	// Infinite loop to update system information every 1 minute
	for {
		// Get Hostname
		hostInfo, err := host.Info()
		if err != nil {
			log.Fatal("Error getting host info:", err)
		}
		hostname := hostInfo.Hostname

		// Get IP Address
		ipAddress, err := getIPAddress()
		if err != nil {
			log.Fatal("Error getting IP address:", err)
		}

		// Get CPU model
		cpuModel, err := getCPUModel()
		if err != nil {
			log.Fatal("Error getting CPU info:", err)
		}

		// Get Memory info
		totalMem, usedMem, err := getMemoryInfo()
		if err != nil {
			log.Fatal("Error getting memory info:", err)
		}

		// Get System Uptime
		uptime, err := getUptime()
		if err != nil {
			log.Fatal("Error getting uptime info:", err)
		}

		// Get WiFi info
		wifi, err := getWiFiInfo()
		if err != nil {
			log.Println(err)
			wifi = "No WiFi info"
		}

		// Get Battery info
		battery, err := getBatteryInfo()
		if err != nil {
			log.Println(err)
			battery = "No Battery info"
		}

		// Get SSH info
		ssh, err := getSSHInfo()
		if err != nil {
			log.Println(err)
			ssh = "No SSH info"
		}

		cpuLoad, err := getCPULoad()
		if err != nil {
			log.Fatal("Error getting CPU load:", err)
		}

		freeMem, err := getFreeMemory()
		if err != nil {
			log.Fatal("Error getting free memory:", err)
		}

		swapTotal, swapUsed, err := getSwapInfo()
		if err != nil {
			log.Fatal("Error getting swap info:", err)
		}

		diskTotal, diskUsed, diskFree, err := getDiskInfo()
		if err != nil {
			log.Fatal("Error getting disk info:", err)
		}

		rxBytes, txBytes, err := getNetworkInfo()
		if err != nil {
			log.Fatal("Error getting network info:", err)
		}

		netSpeed, err := getNetworkSpeed()
		if err != nil {
			log.Fatal("Error getting network speed:", err)
		}

		temp, err := getTemperature()
		if err != nil {
			log.Fatal(err)
		}
		fmt.Println("Temperature:", temp)

		procCount, err := getProcessCount()
		if err != nil {
			log.Fatal("Error getting process count:", err)
		}

		// Get Current Time
		currentTime := time.Now().Format(time.RFC3339)

		// Create a struct for system information
		sysInfo := SystemInfo{
			Hostname:       hostname,
			IP:             ipAddress,
			CPUModel:       cpuModel,
			TotalMemory:    totalMem,
			UsedMemory:     usedMem,
			Uptime:         uptime,
			WiFi:           wifi,
			Battery:        battery,
			SSHInfo:        ssh,
			Timestamp:      currentTime,
			CPULoad:        cpuLoad,
			FreeMemory:     freeMem,
			SwapTotal:      swapTotal,
			SwapUsed:       swapUsed,
			DiskTotal:      diskTotal,
			DiskUsed:       diskUsed,
			DiskFree:       diskFree,
			NetworkRxBytes: rxBytes,
			NetworkTxBytes: txBytes,
			NetworkSpeed:   netSpeed,
			Temperature:    temp,
			ProcessCount:   procCount,
		}

		// Wrap system info inside SystemInfoWrapper with the "system1_info" key
		wrappedInfo := SystemInfoWrapper{
			System1Info: sysInfo,
		}

		// Convert system information to JSON
		jsonData, err := json.Marshal(wrappedInfo)
		if err != nil {
			log.Fatal("Error marshalling system info to JSON:", err)
		}

		// Send the JSON data over WebSocket
		err = conn.WriteMessage(websocket.TextMessage, jsonData)
		if err != nil {
			log.Println("Error sending message:", err)
		}

		// Wait for 1 minute before sending the next update
		time.Sleep(1 * time.Second)
	}
}
