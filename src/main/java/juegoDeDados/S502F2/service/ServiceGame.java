package juegoDeDados.S502F2.service;


import juegoDeDados.S502F2.dto.RankingDTO;
import juegoDeDados.S502F2.models.Game;
import juegoDeDados.S502F2.models.Player;
import juegoDeDados.S502F2.repository.GameRepository;
import juegoDeDados.S502F2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceGame implements GameService {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Object playGame(String id) {
        Player player = playerService.getPlayerById(id);
        Game game = new Game(player.getId(), throwDices());
        gameRepository.save(game);
        return game;
    }

   /* @Override
    public String deleteGamesByIdPlayer(String id) {
        List<Game> games = gameRepository.findAllByPlayerId(id);
        if (games.isEmpty()) {
            return "Player with id " + id + " has no games";
        } else {
            games.forEach(gameRepository::delete);
            return "Games deleted";
        }
    }*/
  /* @Override
   public String deleteGamesByIdPlayer(String id) {
       try {
           List<Game> games = gameRepository.findAllByPlayerId(id);
           if (games.isEmpty()) {
               return "Player with id " + id + " has no games";
           } else {
               games.forEach(gameRepository::delete);
               return "Games deleted";
           }
       } catch (Exception e) {
           // Log the exception
           e.printStackTrace();
           return "An error occurred: " + e.getMessage();
       }
   }*/
   @Override
   public String deleteGamesByIdPlayer(String id) {
       System.out.println("Deleting games for player id: " + id);
       List<Game> games = gameRepository.findAllByPlayerId(id);
       System.out.println("Number of games found: " + games.size());
       if (games.isEmpty()) {
           return "Player with id " + id + " has no games";
       } else {
           for (Game game : games) {
               if (game.getId() != null) {
                   gameRepository.delete(game);
               } else {
                   // Aquí puedes manejar el caso cuando el id del juego es nulo
                   System.out.println("Game with null id found");
               }
           }
           return "Games deleted";
       }
   }




    @Override
    public List<Game> getAllGamesByIdPlayer(String id) {
        return gameRepository.findGamesByPlayerId(id);
    }

    @Override
    public List<RankingDTO> getRankingGames() {
        return calcRanking();
    }

    @Override
    public String getWinnerRankingPlayer() {
        List<RankingDTO> ranking = calcRanking();
        if (ranking.isEmpty()) {
            return "There aren't games";
        }
        return ranking.stream()
                .filter(dto -> dto.getSuccessRate() == ranking.get(0).getSuccessRate())
                .toList()
                .toString();
    }

    @Override
    public String getLoserRankingPlayer() {
        List<RankingDTO> ranking = calcRanking();
        if (ranking.isEmpty()) {
            return "There aren't games";
        }
        return ranking.stream()
                .filter(dto -> dto.getSuccessRate() == ranking.get(ranking.size() - 1).getSuccessRate())
                .toList()
                .toString();
    }

    private List<RankingDTO> calcRanking() {
        List<RankingDTO> ranking = new ArrayList<>();
        List<Player> players = playerRepository.findAll();
        List<Game> games = gameRepository.findAll();

        for (Player player : players) {
            String id = player.getId();
            long countWins = games.stream()
                    .filter(game -> game.getPlayerId().equals(id) && game.getPoints() == 7)
                    .count();
            long totalGames = games.stream()
                    .filter(game -> game.getPlayerId().equals(id))
                    .count();
            double successRate = (countWins > 0) ? (double) countWins / totalGames : 0.0;

            if (totalGames > 0) {
                RankingDTO dto = new RankingDTO(id, player.getName(),(int) countWins,(int) totalGames, successRate);
                ranking.add(dto);
            }
        }

        ranking.sort(Comparator.comparing(RankingDTO::getSuccessRate).reversed());
        return ranking;
    }

    private Integer throwDices() {
        Integer dado1 = new Random().nextInt(6) + 1;
        Integer dado2 = new Random().nextInt(6) + 1;
        return dado1 + dado2;
    }

}
