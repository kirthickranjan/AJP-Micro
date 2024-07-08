import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class UpdateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            roll_no: '',
            name: '',
            cgpa: ''
        }
        this.changeroll_noHandler = this.changeroll_noHandler.bind(this);
        this.changenameHandler = this.changenameHandler.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
            let employee = res.data;
            this.setState({roll_no: employee.roll_no,
                name: employee.name,
                cgpa : employee.cgpa
            });
        });
    }

    updateEmployee = (e) => {
        e.preventDefault();
        let employee = {roll_no: this.state.roll_no, name: this.state.name, cgpa: this.state.cgpa};
        console.log('employee => ' + JSON.stringify(employee));
        console.log('id => ' + JSON.stringify(this.state.id));
        EmployeeService.updateEmployee(employee, this.state.id).then( res => {
            this.props.history.push('/student');
        });
    }
    
    changeroll_noHandler= (event) => {
        this.setState({roll_no: event.target.value});
    }

    changenameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({cgpa: event.target.value});
    }

    cancel(){
        this.props.history.push('/student');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Student</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Roll No: </label>
                                            <input placeholder="Roll No" name="roll_no" className="form-control" 
                                                value={this.state.roll_no} onChange={this.changeroll_noHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="Name" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changenameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> CGPA: </label>
                                            <input placeholder="Email Address" name="cgpa" className="form-control" 
                                                value={this.state.cgpa} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateEmployeeComponent
