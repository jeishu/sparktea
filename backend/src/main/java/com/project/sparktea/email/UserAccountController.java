package com.project.sparktea.email;


public class UserAccountController {

//    @Autowired
//    public UserRepository userRepository;
//
//    @Autowired
//    private ConfirmationTokenRepository confirmationTokenRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    @GetMapping("/register")
//    public ModelAndView displayRegistration(ModelAndView modelAndView, User userEntity)
//    {
//        modelAndView.addObject("userEntity", userEntity);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
//    
//    
//    
//    @PostMapping("/register")
//    public ModelAndView registerUser(ModelAndView modelAndView, User userEntity)
//    {
//
////    	User existingUser = userRepository.findByEmailIdIgnoreCase(userEntity.getEmail());
////        if(existingUser != null)
////        {
////            modelAndView.addObject("message","This email already exists!");
////            modelAndView.setViewName("error");
////        }
////        else
////        {
////            userRepository.save(userEntity);
//
//            ConfirmationToken confirmationToken = new ConfirmationToken(userEntity);
//
//            confirmationTokenRepository.save(confirmationToken);
//
////            SimpleMailMessage mailMessage = new SimpleMailMessage();
////            mailMessage.setTo(userEntity.getEmail());
////            mailMessage.setSubject("Complete Registration!");
////            mailMessage.setFrom("YOUR EMAIL ADDRESS");
////            mailMessage.setText("To confirm your account, please click here : "
////            +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());
//
//      //      emailService.sendEmail(mailMessage);
//
//            modelAndView.addObject("emailId", userEntity.getEmail());
//
//            modelAndView.setViewName("successfulRegisteration");
//        }
//
//        return modelAndView;
//    }
//    
//
//    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
//    {
//        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
//
//        if(token != null)
//        {
//        	User user = userRepository.findByEmailIdIgnoreCase(token.getUserEntity().getEmail());
//    //        user.setEnabled(true);
//            userRepository.save(user);
//            modelAndView.setViewName("accountVerified");
//        }
//        else
//        {
//            modelAndView.addObject("message","The link is invalid or broken!");
//            modelAndView.setViewName("error");
//        }
//        return modelAndView;
//    }
}