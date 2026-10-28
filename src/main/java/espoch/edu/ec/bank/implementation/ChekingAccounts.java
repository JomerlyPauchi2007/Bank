package espoch.edu.ec.bank.implementation;

import espoch.edu.ec.bank.interfaces.InterfazChekingAccount;
import espoch.edu.ec.bank.object.ChekingAccount;

public class ChekingAccounts extends Accounts implements InterfazChekingAccount {

    @Override
    public boolean deposit(ChekingAccount account, float value) {
    
        if (account.getOverdraft()>0) {
            super.deposit(account, value);
         float ax=account.getBalance() -account.getOverdraft();
         
         account.setBalance(ax);
        }
        return true;
    }

    @Override
    public boolean withdraw(ChekingAccount account,float value) {
        if (value> account.getBalance()) {
            float cont= account.getBalance()-value;
            account.setOverdraft(cont);
        }
        float aux = account.getBalance() - value;
            account.setBalance(aux);
        return true;
    }

    @Override
    public boolean montthlyStatement(ChekingAccount account) {
        super.montthlyStatement(account);
        return true;
    }

    @Override
    public String show(ChekingAccount account) {
        return "overdraft= "+account.getOverdraft()+super.show(account);
    }
}
