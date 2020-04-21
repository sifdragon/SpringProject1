<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "spring.ftl" as spring />

<@c.page>
    <h1><@spring.message 'login.page.welcome'/></h1>
    <@l.login "/login" />
    <a href="/registration">Add new user</a>
</@c.page>