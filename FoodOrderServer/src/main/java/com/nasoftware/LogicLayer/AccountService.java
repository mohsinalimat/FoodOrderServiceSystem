package com.nasoftware.LogicLayer;
import com.nasoftware.DataLayer.AccountDataService;
import com.nasoftware.NetworkLayer.ComplitionHandler;

import java.util.HashMap;

public class AccountService {
    public static void login(String account, String password, ComplitionHandler callback) {
        HashMap<String, String> args = new HashMap<String, String>();
        HashMap accountMap = AccountDataService.getAccounts();
        if(accountMap.containsKey(account)) {
            String pass = accountMap.get(account).toString();
            System.out.println(pass);
            System.out.println(password);
            if(pass.equals(password))
                args.put("result", "success");
            else
                args.put("result", "cannot find the correct account or password!");
        }else
            args.put("result", "cannot find the correct account or password!");
        callback.handler(args);
    }

    public static void signUp(String account, String password, ComplitionHandler callback) {
        HashMap<String, String> args = new HashMap<String, String>();
        if(AccountDataService.addAccount(account, password)) {
            args.put("result", "success");
        }else {
            args.put("result", "sorry, the account already exist!");
        }
        callback.handler(args);
    }
}
