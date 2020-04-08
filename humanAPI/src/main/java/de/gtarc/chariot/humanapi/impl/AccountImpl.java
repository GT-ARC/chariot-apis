package de.gtarc.chariot.humanapi.impl;

import de.gtarc.chariot.humanapi.Account;
import org.bson.types.ObjectId;

import java.util.UUID;

public class AccountImpl implements Account {

    private String accountId;
    private String userId;
    private String loginName;
    private String password;
    private ObjectId _id;

    public AccountImpl() {
        this.accountId = UUID.randomUUID().toString();
    }

    public AccountImpl(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
        this.accountId = UUID.randomUUID().toString();
    }

    public AccountImpl(UUID userId, String loginName, String password) {
        this.userId = userId.toString();
        this.loginName = loginName;
        this.password = password;
        this.accountId = UUID.randomUUID().toString();

    }

    public ObjectId getObjectId() {
        return this._id;
    }

    public UUID getUserId() {
        return UUID.fromString(userId);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getAccountId() {
        return UUID.fromString(accountId);
    }

}
