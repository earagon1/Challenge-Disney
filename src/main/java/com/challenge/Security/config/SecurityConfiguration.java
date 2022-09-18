package com.challenge.Security.config;

public class SecurityConfiguration {

   /* @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsCustomService);
    }

    @Bean
    public PasswordEncoder passwordEncoder{
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizaRequests().antNarchers("/auth/*").permitAll
                .anyRequest().authentucated()
                .and().excetionHandling()
                .abd().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
    }*/

}
