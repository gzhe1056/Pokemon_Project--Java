import React, { useEffect, useState } from 'react'
import axios from "axios"
import { Link, useParams } from 'react-router-dom';

export default function Home() {

    const [pokemons, setPokemons] = useState([]);

    const {id}=useParams()

    useEffect(() => {
        loadPokemons();
    }, []);

    const loadPokemons = async () => {
        const result = await axios.get("http://localhost:8090/pokemons")
        setPokemons(result.data);
    }

    const deletePokemon = async (id)=>{
        await axios.delete(`http://localhost:8090/pokemon/${id}`)
        loadPokemons()
    }

    return (
        <div className="container">
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Type</th>
                            <th scope="col">Level</th>
                            <th scope="col">Hitpoints</th>
                            <th scope="col">Attack</th>
                            <th scope="col">Defense</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            pokemons.map((pokemon, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{pokemon.pokemonName}</td>
                                    <td>{pokemon.type}</td>
                                    <td>{pokemon.level}</td>
                                    <td>{pokemon.hp}</td>
                                    <td>{pokemon.attack}</td>
                                    <td>{pokemon.defense}</td>
                                    <td>
                                        <Link className="btn btn-primary mx-2"
                                        to={`/viewpokemon/${pokemon.id}`}>View</Link>
                                        <Link className="btn btn-outline-primary mx-2"
                                        to={`/editpokemon/${pokemon.id}`}>Edit</Link>
                                        <button className="btn btn-danger mx-2"
                                        onClick={()=>deletePokemon(pokemon.id)}>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }

                    </tbody>
                </table>
            </div>
        </div>
    )
}
