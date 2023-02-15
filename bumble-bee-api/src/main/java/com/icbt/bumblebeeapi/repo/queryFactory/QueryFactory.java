package com.icbt.bumblebeeapi.repo.queryFactory;


import com.icbt.bumblebeeapi.entity.User;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.Type;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble_bee
 * @since 2/12/2023
 */
public interface QueryFactory {
 List<User> GenerateSearchQuery(Type type, String value);
}
