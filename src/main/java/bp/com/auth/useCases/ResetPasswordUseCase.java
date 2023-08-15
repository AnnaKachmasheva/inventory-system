package bp.com.auth.useCases;

import bp.com.auth.adapters.UserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResetPasswordUseCase {

    //todo

    private final UserRepositoryAdapter adapter;

//    public void execute(User user, String password) {
//        User foundedUser = adapter.findById(user.getId());
//        if (foundedUser == null) {
//            throw new NoUserFoundException(user.getId());
//        }
//        String token = UUID.randomUUID().toString();
//        createPasswordResetTokenForUser(user, token);
//        mailSender.send(constructResetTokenEmail(getAppUrl(request),
//                request.getLocale(), token, user));
//
//        adapter.resetPassword(password);
//    }
//
//    public void createPasswordResetTokenForUser(User user, String token) {
//        PasswordResetToken myToken = new PasswordResetToken(token, user);
//        passwordTokenRepository.save(myToken);
//    }

}
