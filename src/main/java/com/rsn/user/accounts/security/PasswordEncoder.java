package com.rsn.user.accounts.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends BCryptPasswordEncoder {
}
