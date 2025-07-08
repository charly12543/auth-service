package com.charlyCorporation.SecurityRoles;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SecurityRolesApplication {

	public static void main(String[] args) {

		SpringApplication.run(SecurityRolesApplication.class, args);

		/*Map<String, Object> extraClaims = new HashMap<>();
		extraClaims.put("name", "prueba JWT");

		//Construimos el JWT
		Date issuedAT = new Date(System.currentTimeMillis());
		Date expiration = new Date(issuedAT.getTime() + (1 * 60 * 1000));

		String jwt;
		jwt = Jwts.builder()

				//cabecera
				.header()
				.type("JWT")
				.and()

				//payload
				.subject("pruebaJWT")
				.expiration(expiration)
				.issuedAt(issuedAT)
				.claims(extraClaims)

				//Firma
				.signWith(generateKey(), Jwts.SIG.HS256)
				.compact();

		System.out.println(jwt);

	}

		public static SecretKey generateKey(){

			String secret = "probando los nuevos JWT en mi proyecto 123456";

			return Keys.hmacShaKeyFor(secret.getBytes()); */

		}

}
