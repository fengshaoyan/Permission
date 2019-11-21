package com.android.permission.bridge;


import java.util.concurrent.BlockingQueue;

public final class RequestExecutor extends Thread implements Messenger.Callback {

    private final BlockingQueue<BridgeRequest> mQueue;
    private BridgeRequest mRequest;
    private Messenger mMessenger;

    public RequestExecutor(BlockingQueue<BridgeRequest> queue) {
        this.mQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    mRequest = mQueue.take();
                } catch (InterruptedException e) {
                    continue;
                }

                mMessenger = new Messenger(mRequest.getSource().getContext(), this);
                mMessenger.register();
                executeCurrent();

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void executeCurrent() {
        switch (mRequest.getType()) {
            case BridgeRequest.TYPE_APP_DETAILS: {
                BridgeActivity.requestAppDetails(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_PERMISSION: {
                BridgeActivity.requestPermission(mRequest.getSource(), mRequest.getPermissions());
                break;
            }
            case BridgeRequest.TYPE_INSTALL: {
                BridgeActivity.requestInstall(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_OVERLAY: {
                BridgeActivity.requestOverlay(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_ALERT_WINDOW: {
                BridgeActivity.requestAlertWindow(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_NOTIFY: {
                BridgeActivity.requestNotify(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_NOTIFY_LISTENER: {
                BridgeActivity.requestNotificationListener(mRequest.getSource());
                break;
            }
            case BridgeRequest.TYPE_WRITE_SETTING:{
                BridgeActivity.requestWriteSetting(mRequest.getSource());
                break;
            }
        }
    }

    @Override
    public void onCallback() {
        synchronized (this) {
            mMessenger.unRegister();
            mRequest.getCallback().onCallback();
            notify();
        }
    }
}
