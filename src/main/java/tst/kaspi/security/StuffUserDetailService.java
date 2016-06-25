package tst.kaspi.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tst.kaspi.dao.CredDao;
import tst.kaspi.dao.UserDao;
import tst.kaspi.domain.Credential;
import tst.kaspi.domain.User;

import java.util.ArrayList;
import java.util.List;


@Service("stuffUserDetailsService")
@Configurable
public class StuffUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private CredDao credDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.get(s);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }        Credential credential = credDAO.get(user.getUserId());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                credential.getPass(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getValue()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
