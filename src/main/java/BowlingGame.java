public class BowlingGame {
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        System.out.println(bowlingGame.getBowlingScore("X|7/|9-|X|-8|8/|-6|X|X|X||81"));
    }

    public int getBowlingScore(String bowlingCode) {
        if (bowlingCode==null ||bowlingCode.length()<=0)
            return 0;
        char[] c = bowlingCode.toCharArray();
        int i = 0;
        int X = 0;
        int Y = 0;
        int sum = 0;
        int current = 0;
        int num = 0;
        boolean flag = false;
        while (i < c.length) {
            current = 0;
            num = 0;
            if (c[i] == '|') {
                i++;
                while (i < c.length) {
                    if (flag) {
                        sum += NumofCurrentChar(c[i]) * 2;
                        flag = false;
                    } else
                        sum += NumofCurrentChar(c[i]);
                    i++;
                }
            }
            while (i < c.length && c[i] != '|') {
                int temp = current;
                current = NumofCurrentChar(c[i]);
                if (temp > current) {
                    num = temp;
                } else if (current> temp)
                {
                    num = current;
                    current -= temp;
                }
                    if (X > 0) {
                        if (flag) {
                            sum += current * 2;
                            flag = false;
                        } else
                            sum += current;
                        X--;
                    }
                if (Y > 0) {
                    sum += current;
                    Y--;
                }
                if (c[i] == 'X') {
                    if (X == 1) {
                        flag = true;
                    }
                    X = 2;

                } else if (c[i] == '/') {
                    Y = 1;
                }
                i++;

            }
            sum += num;
            i++;

        }

        return sum;
    }

    private int NumofCurrentChar(char c) {
        int current;
        if (c == '/')
            current = 10;
        else if (c == '-')
            current = 0;
        else if (c == 'X')
            current = 10;
        else
            current = c - '0';
        return current;
    }
}
