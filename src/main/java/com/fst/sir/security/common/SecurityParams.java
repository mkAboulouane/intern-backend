package com.fst.sir.security.common;

public interface SecurityParams {
     static final String JWT_HEADER_NAME = "Authorization";
     static final String SECRET = "8a0ccdbf-8130-4709-87c2-6ef79a2a5c68";
     static final long EXPIRATION = 86400000;

     static final String HEADER_PREFIX = "Bearer ";

}
