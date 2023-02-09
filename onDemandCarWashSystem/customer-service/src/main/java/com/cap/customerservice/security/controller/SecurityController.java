package com.cap.customerservice.security.controller;




import com.cap.customerservice.security.models.AuthenticationRequest;
import com.cap.customerservice.security.models.AuthenticationResponse;
import com.cap.customerservice.security.services.MyUserDetailsService;
import com.cap.customerservice.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;




    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }
        final UserDetails userDetails=userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String jwt= jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
