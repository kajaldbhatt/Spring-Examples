package com.coolspringstuff.jobportal.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.coolspringstuff.jobportal.view.PdfView;

public class PdfViewResolver implements ViewResolver{
	@Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        PdfView view = new PdfView();
        return view;
      }
}
