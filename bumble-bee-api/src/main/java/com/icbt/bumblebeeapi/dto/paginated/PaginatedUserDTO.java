package com.icbt.bumblebeeapi.dto.paginated;

import com.icbt.bumblebeeapi.dto.SuperDTO;
import com.icbt.bumblebeeapi.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/5/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedUserDTO implements SuperDTO {
    private List<UserDTO> list;
    private long count;
}
