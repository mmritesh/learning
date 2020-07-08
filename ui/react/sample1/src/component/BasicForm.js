import React, { Component } from 'react'

export default class BasicForm extends Component {
    state = {
        rows: 0,
        cols: 0,
        tableRows: [],
    }
    
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log("Form Submitted.", this.state);
        let tr = [];
        let tc = [];
        for(let i=0; i<this.state.rows; i++) {
            tc.push(<td key={i}></td>);
        }
        for(let i=0; i<this.state.cols; i++) {
            tr.push(<tr key={i}>{tc}</tr>);
        }
        this.setState({tableRows: tr});
    }

    render() {
        let tableRows = this.state.tableRows;
        return (
            <div>
                <form className="TableForm" onSubmit={this.handleSubmit}>
                    <label> Rows: 
                        <input type="text" name="rows" placeholder="Rows" onChange={this.handleChange} /> 
                    </label>

                    <label> Cols: 
                        <input type="text" name="cols" placeholder="Columns" onChange={this.handleChange} />
                    </label>

                    <input type="Submit" />
                </form>
                <table>
                    <tbody>
                        {tableRows}
                    </tbody>
                </table>
            </div>
        )
    }
}
