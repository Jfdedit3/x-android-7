package com.jfdedit3.xandroid7;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends Activity {
    private static final String HOME_URL = "https://x.com/";

    private static GeckoRuntime runtime;

    private GeckoSession session;
    private boolean canGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GeckoView geckoView = new GeckoView(this);
        geckoView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        FrameLayout root = new FrameLayout(this);
        root.addView(geckoView);
        setContentView(root);

        if (runtime == null) {
            runtime = GeckoRuntime.create(this);
        }

        session = new GeckoSession();
        session.setContentDelegate(new GeckoSession.ContentDelegate() {});
        session.setNavigationDelegate(new GeckoSession.NavigationDelegate() {
            @Override
            public void onCanGoBack(GeckoSession session, boolean canGoBack) {
                MainActivity.this.canGoBack = canGoBack;
            }
        });

        session.open(runtime);
        geckoView.setSession(session);

        if (savedInstanceState == null) {
            session.loadUri(HOME_URL);
        }
    }

    @Override
    public void onBackPressed() {
        if (session != null && canGoBack) {
            session.goBack();
            return;
        }

        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (session != null) {
            session.close();
            session = null;
        }

        super.onDestroy();
    }
}
