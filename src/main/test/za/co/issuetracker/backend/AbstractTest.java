package za.co.issuetracker.backend;

import za.co.issuetracker.backend.user.service.UserService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * An abstract test class
 *
 * @author Jaco Koekemoer
 * Date: 2023-02-24
 */
public abstract class AbstractTest
{

    public UserService lookupUserService(String beanName)
    {
        try
        {
            Hashtable environment = new Hashtable();
            environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            String providerUrl = String.format("http-remoting://127.0.0.1:8080/wildfly-services");
            environment.put(Context.PROVIDER_URL, providerUrl);
            environment.put(Context.SECURITY_PRINCIPAL, "jacok");
            environment.put(Context.SECURITY_CREDENTIALS, "password1!");
            Context context = new InitialContext(environment);
            String lookupName = String.format("java:issue-tracker/%s", beanName);
            UserService userService = (UserService) context.lookup(lookupName);
//            UserService userService = (UserService) context.lookup("java:issue-tracker/UserServiceBean!za.co.issuetracker.backend.user.service.UserService");
            return userService;
        }
        catch (NamingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
