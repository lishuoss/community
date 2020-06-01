package com.test.coummity.controller;/*
 * @author 李硕
 *
 */

import com.test.coummity.dto.AccessTokenDTO;
import com.test.coummity.dto.GithubUser;
import com.test.coummity.prodiver.GithubProdiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProdiver githubProdiver;
    @Autowired
    private AccessTokenDTO accessTokenDTO;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private String redirectUrl;



    @GetMapping("/callback")
    public String callback(@RequestParam("code")String code,@RequestParam("state") String state){

        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        String accessToken = githubProdiver.getAccessToken(accessTokenDTO);
        GithubUser user = githubProdiver.getUser(accessToken);
        return "index";
    }


}
