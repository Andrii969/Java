package api;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
public class UserData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
