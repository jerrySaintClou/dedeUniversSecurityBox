package DedeUniversWebSecurity.dedeUniversSecurityBox.controllers;

import DedeUniversWebSecurity.dedeUniversSecurityBox.entities.User;
import DedeUniversWebSecurity.dedeUniversSecurityBox.repositories.UserRepository;
import DedeUniversWebSecurity.dedeUniversSecurityBox.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class RegistrationLoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.badRequest().body("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return ResponseEntity.ok("login is succesfull");
        } catch (Exception e){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
