import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleColorBall {
    private static final int RED_BALL_MAX = 33;
    private static final int RED_BALL_COUNT = 6;
    private static final int BLUE_BALL_MAX = 16;

    private Set<Integer> winningRedBalls;
    private int winningBlueBall;

    public DoubleColorBall() {
        generateWinningNumbers();
    }

    private void generateWinningNumbers() {
        winningRedBalls = new HashSet<>();
        while (winningRedBalls.size() < RED_BALL_COUNT) {
            winningRedBalls.add(ThreadLocalRandom.current().nextInt(1, RED_BALL_MAX + 1));
        }
        winningBlueBall = ThreadLocalRandom.current().nextInt(1, BLUE_BALL_MAX + 1);
    }

    public void checkUserBalls(Set<Integer> userRedBalls, int userBlueBall) {
        if (userRedBalls == null || userRedBalls.size() != RED_BALL_COUNT || userBlueBall <= 0 || userBlueBall > BLUE_BALL_MAX) {
            System.out.println("非法输入！");
            return;
        }

        // 对红球号码进行判定
        int matchedRedCount = 0;
        for (Integer redBall : userRedBalls) {
            if (redBall <= 0 || redBall > RED_BALL_MAX) {
                System.out.println("红球号码非法，请输入1-33之间的号码");
                return;
            }
            if (winningRedBalls.contains(redBall)) {
                matchedRedCount++;
            }
        }

        // 对蓝球号码进行判断
        boolean isBlueBallMatched = (userBlueBall == winningBlueBall);

        // 输出中奖结果
        System.out.println("您中了" + matchedRedCount + "个红球" + (isBlueBallMatched ? "和蓝球" : "") + "！");
        // 根据中奖情况，可以增加对应的奖金判定逻辑
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleColorBall lottery = new DoubleColorBall();

        // 输出中奖号码，实际操作时不应该这样做，仅为演示
        System.out.println("本期中奖红球号码为：" + lottery.winningRedBalls);
        System.out.println("本期中奖蓝球号码为：" + lottery.winningBlueBall);

        System.out.println("请输入您选择的六个红球号码（1-33之间，用空格隔开）：");
        Set<Integer> userRedBalls = new HashSet<>();
        while (userRedBalls.size() < RED_BALL_COUNT) {
            int redBall = scanner.nextInt();
            userRedBalls.add(redBall);
        }

        System.out.println("请输入您选择的一个蓝球号码（1-16之间）：");
        int userBlueBall = scanner.nextInt();

        lottery.checkUserBalls(userRedBalls, userBlueBall);
    }
}