import React from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import axios from "axios";
class App extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <Search></Search>
      </div>
    );
  }
}

class Search extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      type: 'non-vegan',
      profile: 'savory',
      cost: '15',
      searchResult: [],
      error: ''
    }
    this.renderResult = this.renderResult.bind(this);
  }

  onChangeType(event) {
    this.setState({
      type: event.target.value
    });
  }

  onChangeProfile(event) {
    this.setState({
      profile: event.target.value
    });
  }

  onChangeCost(event) {
    this.setState({
      cost: event.target.value
    });
  }

  submitForm() {
    Api.search(this.state.type, this.state.profile, this.state.cost)
      .then((res) => {
        this.setState({
          searchResult: res.data
        });
      });
  }

  renderResult() {
    const list = this.state.searchResult.map(
      foods =>
      <div key={foods._id}>
        <SearchResult foods={foods}/>
      </div>
    );
    return (list);
  }

  render() {
    return (
      <div>
        <div>
          <div>Type of meal</div>
          <select  id="type" onChange={this.onChangeType.bind(this)}>
            <option value="-1" disabled>--</option>
            <option value="non-vegan">Non-vegan</option>
            <option value="vegan">Vegan</option>
          </select>
        </div>
        <div>
          <div>flavour profile</div>
          <select  id="profile" onChange={this.onChangeProfile.bind(this)}>
            <option value="-1" disabled>--</option>
            <option value="savory">Savory</option>
            <option value="sweet">Sweet</option>
          </select>
        </div>
        <div>
          <div>Cost</div>
          <select id="cost" onChange={this.onChangeCost.bind(this)}>
            <option value="-1" disabled>--</option>
            <option value="15">5 to 15 euro</option>
            <option value="25">15 to 25 euro</option>
          </select>
        </div>
        <button onClick={this.submitForm.bind(this)}> Search now</button>
        <div>
          {this.renderResult()}
        </div>
      </div>
    )
  }
}

class SearchResult extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div>
        <ul>
          <li><img src={this.props.foods.imageUrl} width="100px" height="100px" alt="whatever"></img></li>
          <li>{this.props.foods.name}</li>
          <li>{this.props.foods.totalTime}</li>
          <li>{this.props.foods.calories}</li>
        </ul>
        <br></br>
      </div>
    )
  }
}

const Api = {
  search: function(type, profile, cost) {
    const authKey = "5cj3F0nQw4ngucb3XjmYCeWpnnxqshoF";
    const queryURL = "https://api.mlab.com/api/1/databases/recipe/collections/recipe?apiKey=" +
    authKey + "&q={'type':" + JSON.stringify(type) + "," + "'flavourProfile':" + JSON.stringify(profile) + "," + "'cost':" + JSON.stringify(cost) + "}";
    return axios.get(queryURL);
  }
};

ReactDOM.render(<App />, document.getElementById('root'));
