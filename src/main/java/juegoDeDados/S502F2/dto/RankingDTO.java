package juegoDeDados.S502F2.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.text.DecimalFormat;


@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO implements Serializable {

    private String id;
    private String namePlayer;
    private int gamesWon;
    private int gamesTotal;
    private double successRate;



    public double getSuccessRate() {
        return successRate;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##0.00");
        return "id: "  + id +
                " "  + namePlayer +
                " , Won= "  + gamesWon +
                " , Total="  + gamesTotal +
                " , successRate="  + df.format(successRate * 100) +  "%\n";

    }
}

