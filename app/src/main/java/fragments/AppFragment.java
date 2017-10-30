package fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.techman.newske.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment extends Fragment {
ProgressBar pb;
    WebView webView;

    public AppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app, container, false);

        pb =(ProgressBar)view.findViewById(R.id.progress3);
        // final ProgressDialog pd = ProgressDialog.show(getContext(),"","Just a moment...",true);
        webView = (WebView)view.findViewById(R.id.webview3);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.loadUrl("http://www.the-star.co.ke/");
        webView.setWebViewClient(new WebViewClient(){
                                     @Override
                                     public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                                         Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                                     }

                                     @Override
                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                         // pd.show();
                                         pb.setVisibility(View.VISIBLE);
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         if (pb !=null){
                                             // pd.dismiss();
                                             pb.setVisibility(View.GONE);
                                         }
                                         String webUrl = webView.getUrl();
                                     }
                                 }
        );
        return view;
    }

}
