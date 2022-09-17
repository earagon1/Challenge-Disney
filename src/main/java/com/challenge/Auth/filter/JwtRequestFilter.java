package com.challenge.Auth.filter;

public class JwtRequestFilter/*extends OncePerRequestFilter*/ {
/*
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException{

        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            jwt = authorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
            }
        }

    }*/
}
