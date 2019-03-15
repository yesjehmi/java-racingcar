package car.entity;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Car> aRoundResult;

    public GameResult() {
        aRoundResult = new ArrayList<>();
    }

    public static GameResult createResultInstance(List<Car> result) {
        GameResult gameResult = new GameResult();
        gameResult.aRoundResult = result;
        return gameResult;
    }

    public List<Car> getRoundResult() {
        return aRoundResult;
    }


    public String getWinnerNames() {
        int maxMovement = getMaxMovement();
        StringBuffer winnerNamesStringBuffer = new StringBuffer();

        aRoundResult.stream()
                .filter(car -> car.getMovingCount() >= maxMovement)
                .forEach(car-> {
                    winnerNamesStringBuffer.append(car.getName()+ " ");
                });

        return winnerNamesStringBuffer.toString();
    }

    public int getMaxMovement() {
        return aRoundResult.stream()
                .mapToInt(car -> car.getMovingCount())
                .max()
                .orElse(0);
    }
}
