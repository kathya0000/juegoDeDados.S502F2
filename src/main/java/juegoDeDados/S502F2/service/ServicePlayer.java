package juegoDeDados.S502F2.service;


import juegoDeDados.S502F2.dto.PlayerDTO;
import juegoDeDados.S502F2.exceptions.ElementAlreadyExistsException;
import juegoDeDados.S502F2.exceptions.ElementNotFoundException;
import juegoDeDados.S502F2.models.Player;
import juegoDeDados.S502F2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@Service
@AllArgsConstructor

public class ServicePlayer implements PlayerService{

    @Autowired
    ModelMapper modelMapper;
    private final PlayerRepository playerRepository;



    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        if (findByName(playerDTO))
            throw new ElementAlreadyExistsException(Player.class, playerDTO.getName());
        else {
            Player player = playerRepository.save(convertDtoToEntity(playerDTO));
            return convertEntityToDto(player);
        }
    }

    @Override
    public Object updatePlayer(String id, PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isEmpty())
            throw new ElementNotFoundException(Player.class, id);
        else {
            if (findByName(playerDTO))
                throw new ElementAlreadyExistsException(Player.class, playerDTO.getName());
            else {
                Player player = playerOptional.get();
                player.setName(playerDTO.getName());
                return playerRepository.save(player);
            }

        }
    }

    @Override
    public  Player getPlayerById(String id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isEmpty()) throw new ElementNotFoundException(Player.class, id);
        Player player = optionalPlayer.get();
        return player;
    }

    private boolean findByName(PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findPlayerByName(playerDTO.getName());
        if (playerOptional.isPresent())
            return true;
        else
            return false;
    }

    private Player convertDtoToEntity(PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        if (player.getName() == null || player.getName() == "") player.setName("ANONIMO");
        if (player.getDate() == null) player.setDate(new Date());
        return player;
    }

    private PlayerDTO convertEntityToDto(Player player) {

        return new PlayerDTO(player.getId(), player.getName());
    }

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }



}


