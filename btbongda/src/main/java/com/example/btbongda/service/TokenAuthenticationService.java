package flutterapi.service;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import flutterapi.model.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 604800000; // 7 days

	static final String SECRET = "techmaster";

	static final String TOKEN_PREFIX = "Bearer";

	static final String HEADER_STRING = "Authorization";
	
	private static TokenAuthenticationService instance;
	
	private TokenAuthenticationService() {
	}
	
	public static TokenAuthenticationService getInstance() {
		if(instance == null) {
			instance = new TokenAuthenticationService();
		}
		return instance;
	}
	
	public static String createToken(Token tokenInfo) {
		Claims claims = Jwts.claims().setSubject(tokenInfo.getUserId());
        claims.put("userId", tokenInfo.getUserId());
        claims.put("isAuthenticated", tokenInfo.isAuthenticated());
        
		String JWT = Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		String token = TOKEN_PREFIX + " " + JWT;
		return token;
	}
	
	public static Token validateToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			try {
				Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
				if (claims.getBody().getExpiration().before(new  Date())) {
					return null;
				}
				
				String userId = (String) claims.getBody().get("userId"); 
				boolean isAuthenticated = (boolean) claims.getBody().get("isAuthenticated"); 
				Token auth = new Token(userId, isAuthenticated);
				
	            return auth;
	        } catch (JwtException | IllegalArgumentException e) {
	            throw new JwtException("Token không hợp lệ");
	        }
		}
		return null;
	}
}
