package com.challenge.Auth.service;

public class UserDetailsCustomService implements UserDetailService {
    /*

    @Autowired
    private UserRepository userRepository;

    @Autowired

    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(userName);
        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUserName(),userEntity.getPassword(), Collections.emptyListIterator());
    }

    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity =this.userRepository.save(userEntity);
        if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUserName());
        }
        return userEntity != null;
    }*/
}
