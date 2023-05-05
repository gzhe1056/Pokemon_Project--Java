import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import axios from 'axios'

export default function ViewPokemon() {

    const [pokemon, setPokemon]=useState({
        pokemonName: "",
        type: "",
        level: "",
        hp: "",
        attack: "",
        defense: ""
    })

    const {id}=useParams();
    useEffect(()=>{
        loadPokemon();
    }, []);

    const loadPokemon=async ()=>{
        const result=await axios.get(`http://localhost:8090/pokemon/${id}`)
        setPokemon(result.data)
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Pokemon Info</h2>

                    <div className="card">
                        <div className="card-header">
                            Pokemon Info for ID: {pokemon.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name: </b>
                                    {pokemon.pokemonName}
                                </li>
                                <li className="list-group-item">
                                    <b>Type: </b>
                                    {pokemon.type}
                                </li>
                                <li className="list-group-item">
                                    <b>Level: </b>
                                    {pokemon.level}
                                </li>
                                <li className="list-group-item">
                                    <b>Hitpoints: </b>
                                    {pokemon.hp}
                                </li>
                                <li className="list-group-item">
                                    <b>Attack: </b>
                                    {pokemon.attack}
                                </li>
                                <li className="list-group-item">
                                    <b>Defense: </b>
                                    {pokemon.defense}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to={"/"}>Back</Link>
                </div>
            </div>
        </div>
    )
}
