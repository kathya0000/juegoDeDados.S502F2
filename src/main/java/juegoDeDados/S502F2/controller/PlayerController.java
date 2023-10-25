package juegoDeDados.S502F2.controller;


import juegoDeDados.S502F2.dto.PlayerDTO;
import juegoDeDados.S502F2.service.ServicePlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {

    public final ServicePlayer playerService;

    @PostMapping("/add")
    public ResponseEntity<Object> createPlayer(@RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok().body(playerService.createPlayer(playerDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePlayer(@PathVariable String id, @RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok().body(playerService.updatePlayer(id, playerDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
}
