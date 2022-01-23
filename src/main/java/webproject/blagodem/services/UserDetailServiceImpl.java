package webproject.blagodem.services;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import webproject.blagodem.repo.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepo userRepo;

    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            webproject.blagodem.entities.User user = userRepo.findByEmail(username);
            if (user != null) {
                return User.withUsername(user.getEmail())
                        .password(user.getPassword())
                        .roles(user.getRole())
                        .build();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }

}
