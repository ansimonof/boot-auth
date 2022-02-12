package org.myorg.module.auth;

import org.myorg.modules.modules.Module;
import org.myorg.modules.modules.BootModule;
import org.myorg.modules.modules.exception.ModuleException;
import org.springframework.stereotype.Component;

@Component
@BootModule(
        uuid = AuthModuleConsts.UUID
)
public class AuthModule extends Module {

    public AuthModule() {
    }

    @Override
    public void init() throws ModuleException {

    }

    @Override
    public void destroy() throws ModuleException {

    }
}
