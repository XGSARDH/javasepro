import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DoubleColorBall2 {
    // 双色球的红球号码范围和个数
    private static final int RED_BALL_MAX = 33;
    private static final int RED_BALL_COUNT = 6;

    // 双色球的蓝球号码范围
    private static final int BLUE_BALL_MAX = 16;

    public static void main(String[] args) {
        // 生成中奖号码
        int[] winningNumbers = generateWinningNumbers();
        System.out.println("欢迎参与双色球抽奖！");
        System.out.println("（温馨提示：合法的红球号码为1-33，蓝球号码为1-16）");

        // 用户输入抽到的号码
        int[] userNumbers = inputUserNumbers();

        // 判断中奖情况
        checkWinning(winningNumbers, userNumbers);
    }

    // 随机生成中奖号码
    private static int[] generateWinningNumbers() {
        Random random = new Random();
        int[] numbers = new int[RED_BALL_COUNT + 1]; // 额外一位用于存储蓝球号码

        // 生成红球号码
        for (int i = 0; i < RED_BALL_COUNT; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(RED_BALL_MAX) + 1;
            } while (contains(numbers, randomNumber));
            numbers[i] = randomNumber;
        }

        // 生成蓝球号码
        numbers[RED_BALL_COUNT] = random.nextInt(BLUE_BALL_MAX) + 1;

        // 返回生成的号码
        return numbers;
    }

    // 用户输入号码
    private static int[] inputUserNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[RED_BALL_COUNT + 1];

        System.out.println("请输入你选择的6个红球号码（1-33）：");
        for (int i = 0; i < RED_BALL_COUNT; i++) {
            numbers[i] = scanner.nextInt();
            // 检查红球号码是否合法
            if (numbers[i] < 1 || numbers[i] > RED_BALL_MAX || contains(Arrays.copyOf(numbers, i), numbers[i])) {
                System.out.println("输入有误，请重新输入第 " + (i + 1) + " 个红球号码：");
                i--;
            }
        }
        System.out.println("请输入你选择的蓝球号码（1-16）：");
        numbers[RED_BALL_COUNT] = scanner.nextInt();
        // 检查蓝球号码是否合法
        if (numbers[RED_BALL_COUNT] < 1 || numbers[RED_BALL_COUNT] > BLUE_BALL_MAX) {
            System.out.println("输入有误，请重新输入蓝球号码：");
            numbers[RED_BALL_COUNT] = scanner.nextInt();
        }

        scanner.close();
        return numbers;
    }

    // 检查数组中是否含有某个值
    private static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // 判断中奖情况
    private static void checkWinning(int[] winningNumbers, int[] userNumbers) {
        // 计算中奖的红球数
        int matchRedCount = 0;
        for (int i = 0; i < RED_BALL_COUNT; i++) {
            if (contains(winningNumbers, userNumbers[i])) {
                matchRedCount++;
            }
        }

        // 判断蓝球是否中奖
        boolean matchBlue = winningNumbers[RED_BALL_COUNT] == userNumbers[RED_BALL_COUNT];

        // 输出开奖结果
        System.out.println("本期中奖号码为：");
        for (int i = 0; i < RED_BALL_COUNT; i++) {
            System.out.print(winningNumbers[i] + " ");
        }
        System.out.println("+ " + winningNumbers[RED_BALL_COUNT]);

        // 输出用户中奖情况
        System.out.println("你的号码为：");
        for (int i = 0; i < RED_BALL_COUNT; i++) {
            System.out.print(userNumbers[i] + " ");
        }
        System.out.println("+ " + userNumbers[RED_BALL_COUNT]);
        System.out.println("你中了" + matchRedCount + "个红球" + (matchBlue ? "和蓝球" : ""));
        // 下面可根据 matchRedCount 和 matchBlue 来判断具体的中奖等级和奖金，然后输出相应的信息
        // ...
    }
}