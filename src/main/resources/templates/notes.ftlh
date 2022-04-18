<#import "parts/common.ftlh" as c>

<@c.page>
    <a href="/api/notes/create">Create note</a>
    <div>Note list</div>
    <#list notes as note>
        <div>
            <b>${note.getName()}</b>
            <p>${note.getNote()}</p>
            <br>
        </div>
    </#list>

</@c.page>