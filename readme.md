# JAVA-LIB NUMBER GAME

## Preview
![preview](https://raw.githubusercontent.com/boyu8266/java-lib-number-game/master/images/preview.gif "preview")

## Example
``` java
public class GameTest {

    public static void main(String... args) {
        NumberGame game = new NumberGame(100);
        HintType hintType = game.getHintType();

        Scanner reader = new Scanner(System.in);
        while (hintType != HintType.THE_RIGHT_ANSWER) {
            System.out.println(hintType.getMin() + " ~ " + hintType.getMax() + ": ");
            int n = reader.nextInt();
            hintType = game.guessNumber(n);
            System.out.println("------");
        }
        System.out.println("lucky number: " + hintType.getMax());
        System.out.println("guess number: " + hintType.getMin());
        reader.close();
    }

}
```

## LICENSE
[MIT](https://github.com/boyu8266/java-lib-number-game/blob/master/LICENSE)