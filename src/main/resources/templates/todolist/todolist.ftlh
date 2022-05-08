<#import "../parts/common.ftlh" as c>

<@c.page>
    <a href="/api/todolist/all">Notes list</a>
    <#if response.role != 'VIEWER'>
        <form method="post" action="/api/todolist/task/create/${response.toDoList.id}">
            <label>
                <input type="text" name="task" value="">
            </label>
            <p><input type="submit" value="Create"></p>
        </form>
    </#if>
    <form method="post" action="/api/todolist/update/${response.toDoList.id}">
        <div>
            <label>
                <input
                        <#if response.role == 'VIEWER'>readonly</#if>
                        type="text" name="name" size="40"
                        value="${response.toDoList.name}">
            </label>
        </div>
        <#list response.toDoList.tasks as task>
            <div>
                <input type="hidden" name="tasks[${task?counter}].id" value="${task.id}">
                <label>
                    <input <#if response.role == 'VIEWER'>readonly</#if> type="text" name="tasks[${task?counter}].task"
                           value="${task.task}"/>
                </label>
                <label>
                    <select <#if response.role == 'VIEWER'>readonly</#if> name="tasks[${task?counter}].state">
                        <#list response.states as state>
                            <option value="${state}" <#if task.state == state>selected</#if>> ${state.description}</option>
                        </#list>
                    </select>
                </label>
            </div>
            <br>
        </#list>
        <#if response.role != 'VIEWER'>
            <p><input type="submit" value="Update"></p>
        </#if>
    </form>
</@c.page>