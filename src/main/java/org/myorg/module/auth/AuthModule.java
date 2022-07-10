package org.myorg.module.auth;

import org.myorg.modules.modules.Module;
import org.myorg.modules.modules.BootModule;
import org.myorg.modules.modules.exception.ModuleException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@BootModule(
        uuid = AuthModuleConsts.UUID
)
@PropertySource(
        value = "boot-properties/auth.application.properties"
)
public class AuthModule extends Module {

    public AuthModule() {
    }

    @Override
    public void onStart() throws ModuleException {

    }

    @Override
    public void onDestroy() throws ModuleException {

    }
}
