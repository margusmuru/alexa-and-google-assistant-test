package csgoInventory.models;

import com.google.actions.api.ActionContext;
import com.google.actions.api.ActionRequest;
import com.google.api.services.actions_fulfillment.v2.model.*;
import com.google.api.services.dialogflow_fulfillment.v2.model.WebhookRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ActionRequestImpl implements ActionRequest {
    @Nullable
    @Override
    public AppRequest getAppRequest() {
        return null;
    }

    @Nullable
    @Override
    public List<Surface> getAvailableSurfaces() {
        return null;
    }

    @NotNull
    @Override
    public Map<String, Object> getConversationData() {
        return null;
    }

    @Nullable
    @Override
    public Device getDevice() {
        return null;
    }

    @NotNull
    @Override
    public String getIntent() {
        return null;
    }

    @Nullable
    @Override
    public Boolean isFinalPrompt() {
        return null;
    }

    @Override
    public boolean isInSandbox() {
        return false;
    }

    @NotNull
    @Override
    public Locale getLocale() {
        return null;
    }

    @Nullable
    @Override
    public RawInput getRawInput() {
        return null;
    }

    @Nullable
    @Override
    public String getRawText() {
        return null;
    }

    @Nullable
    @Override
    public Integer getRepromptCount() {
        return null;
    }

    @Nullable
    @Override
    public String getSessionId() {
        return null;
    }

    @Nullable
    @Override
    public Surface getSurface() {
        return null;
    }

    @Nullable
    @Override
    public User getUser() {
        return null;
    }

    @NotNull
    @Override
    public Map<String, Object> getUserStorage() {
        return null;
    }

    @Nullable
    @Override
    public WebhookRequest getWebhookRequest() {
        return null;
    }

    @Nullable
    @Override
    public Argument getArgument(@NotNull String s) {
        return null;
    }

    @Nullable
    @Override
    public ActionContext getContext(@NotNull String s) {
        return null;
    }

    @NotNull
    @Override
    public List<ActionContext> getContexts() {
        return null;
    }

    @Nullable
    @Override
    public DateTime getDateTime() {
        return null;
    }

    @Nullable
    @Override
    public String getMediaStatus() {
        return null;
    }

    @Nullable
    @Override
    public Object getParameter(@NotNull String s) {
        return null;
    }

    @Nullable
    @Override
    public Location getPlace() {
        return null;
    }

    @Nullable
    @Override
    public String getSelectedOption() {
        return null;
    }

    @Override
    public boolean getUserConfirmation() {
        return false;
    }

    @Override
    public boolean hasCapability(@NotNull String s) {
        return false;
    }

    @Override
    public boolean isPermissionGranted() {
        return false;
    }

    @Override
    public boolean isSignInGranted() {
        return false;
    }

    @Override
    public boolean isUpdateRegistered() {
        return false;
    }
}
