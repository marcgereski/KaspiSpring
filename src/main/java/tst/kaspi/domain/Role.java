package tst.kaspi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "VALUE")
    private String value;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    public Role() {
    }

    public Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
