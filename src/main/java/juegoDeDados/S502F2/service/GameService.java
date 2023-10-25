package juegoDeDados.S502F2.service;

import juegoDeDados.S502F2.dto.RankingDTO;
import juegoDeDados.S502F2.models.Game;
import java.util.List;

public interface GameService {


    Object playGame(String id);
    String deleteGamesByIdPlayer(String id);
    List<Game> getAllGamesByIdPlayer(String id);
    List<RankingDTO> getRankingGames();
    String getWinnerRankingPlayer();
    String getLoserRankingPlayer();

}
