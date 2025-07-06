package com.rsn.user.accounts.repository;


import com.rsn.user.accounts.dto.SearchParamsDto;
import com.rsn.user.accounts.entities.User;

import java.util.List;

public interface UserOperationRepository {
     List<User> searchUsersByParams(SearchParamsDto params);
}
