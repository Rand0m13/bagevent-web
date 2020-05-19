import React, { Component } from "react";
import ReactDOM from "react-dom";
import { SchemaModel, StringType, NumberType } from "schema-typed";
import { FormItem, Form, FormItemContext } from "react-form-next";
import "react-form-next/index.css";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            values: {
                username: "",
                email: "",
                age: "N/A"
            },
            formErr: {} // 校验信息字段
        };

        // 创建检验schema
        this.formModel = SchemaModel({
            username: StringType().isRequired("用户名不能为空"),
            email: StringType()
                .isRequired("邮箱不能为空")
                .isEmail("请输入正确的邮箱"),
            age: NumberType("年龄应该是一个数字")
                .range(18, 30, "年应该在 18 到 30 岁")
                .isRequired("年龄不能为空")
        });
    }
    handleChange = (name, value) => {
    // age 实时检验
    if (name === "age") {
    const { formErr } = this.state;
// checkForField 单个检验
formErr[name] = this.formModel.checkForField(name, value);
this.setState({
    formErr: Object.assign({}, formErr)
});
}

this.setState({
    values: {
        [name]: value
    }
});
};

checkForm = () => {
    // check 全部校验
    this.setState({
        formErr: this.formModel.check(this.state.values)
    });
};
render() {
    return (
        <div className="App">
        <h2>表单</h2>
        <Form
    values={this.state.values}
    checkMsg={this.state.formErr}
    onChange={this.handleChange}
        >
        <FormItemContext label="用户名" type="text" name="username" />
        <FormItemContext label="邮箱" type="email" name="email" />
        <FormItemContext label="年龄" type="number" name="age" />
        <FormItem label="" name="submit">
        <span
    className="s-btn s-btn--primary s-btn--m"
    onClick={this.checkForm}
        >
        提交
        </span>
        </FormItem>
        </Form>
        </div>
);
}
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);