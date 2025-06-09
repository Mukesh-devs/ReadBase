package com.zsgs.readbase.repository.db;

import com.zsgs.readbase.repository.dto.RegistrationInfo;

public class ReadBaseDb {
    private static ReadBaseDb readBaseDb;
    private RegistrationInfo registrationInfo;

    public static ReadBaseDb getInstance() {
        if ( readBaseDb != null) {
            return readBaseDb;
        }
        else {
            readBaseDb = new ReadBaseDb();
            return readBaseDb;
        }
    }

    public RegistrationInfo getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }
}
