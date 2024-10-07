package MentorEvaluation;

import java.util.*;


class SnakeAndLadderGame {
    private int boardSize;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private List<String> players;
    private Map<String, Integer> playerPositions;

    public SnakeAndLadderGame(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<String> players) {
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.playerPositions = new HashMap<>();
        for (String player : players) {
            playerPositions.put(player, 0);
        }
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private void movePlayer(String player, int steps) {
        int currentPosition = playerPositions.get(player);
        int newPosition = Math.min(currentPosition + steps, boardSize * boardSize);
        for (Map.Entry<Integer, Integer> entry : snakes.entrySet()) {
            if (newPosition == entry.getKey()) {
                newPosition = entry.getValue();
                System.out.println("Oops! " + player + " got bitten by a snake and moved from " + entry.getKey() + " to " + entry.getValue() + ".");
                break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : ladders.entrySet()) {
            if (newPosition == entry.getKey()) {
                newPosition = entry.getValue();
                System.out.println("Yay! " + player + " climbed a ladder and moved from " + entry.getKey() + " to " + entry.getValue() + ".");
                break;
            }
        }
        playerPositions.put(player, newPosition);
        System.out.println(player + " rolled a " + steps + " and moved from " + currentPosition + " to " + newPosition + ".");
    }

    public void playGame() {
        while (true) {
            for (String player : players) {
                int steps = rollDice();
                movePlayer(player, steps);
                if (playerPositions.get(player) == boardSize * boardSize) {
                    System.out.println(player + " wins the game!");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        int boardSize = scanner.nextInt();

        Map<Integer, Integer> snakes = new HashMap<>();
        System.out.print("Enter the number of snakes: ");
        int numSnakes = scanner.nextInt();
        for (int i = 0; i < numSnakes; i++) {
            System.out.print("Enter snake head and tail separated by space: ");
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head, tail);
        }

        Map<Integer, Integer> ladders = new HashMap<>();
        System.out.print("Enter the number of ladders: ");
        int numLadders = scanner.nextInt();
        for (int i = 0; i < numLadders; i++) {
            System.out.print("Enter ladder bottom and top separated by space: ");
            int bottom = scanner.nextInt();
            int top = scanner.nextInt();
            ladders.put(bottom, top);
        }

        List<String> players = new ArrayList<>();
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            players.add(scanner.next());
        }

        SnakeAndLadderGame game = new SnakeAndLadderGame(boardSize, snakes, ladders, players);
        game.playGame();
    }
}
