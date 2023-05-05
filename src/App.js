import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import AddPokemon from './pokemon/AddPokemon';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import EditPokemon from './pokemon/EditPokemon';
import ViewPokemon from './pokemon/ViewPokemon';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route exact path="/addpokemon" element={<AddPokemon/>}/>
          <Route exact path="/editpokemon/:id" element={<EditPokemon/>}/>
          <Route exact path="/viewpokemon/:id" element={<ViewPokemon/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
