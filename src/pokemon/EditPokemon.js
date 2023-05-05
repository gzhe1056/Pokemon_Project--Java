import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

export default function EditPokemon() {

    let navigate=useNavigate();

    const {id}=useParams()

    const [pokemon, setPokemon] = useState({
        pokemonName: "",
        type: "",
        level: "",
        hp: "",
        attack: "",
        defense: ""
    })

    const { pokemonName, type, level, hp, attack, defense } = pokemon

    const onInputChange = (e) => {

        setPokemon({ ...pokemon, [e.target.name]: e.target.value })

    }

    useEffect(()=> {
        loadPokemon();
    }, []);

    const onAdd = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:8090/pokemon/${id}`, pokemon)
        navigate("/");
    };

    const loadPokemon = async ()=> {
        const result = await axios.get(`http://localhost:8090/pokemon/${id}`);
        setPokemon(result.data);
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Edit Pokemon</h2>
                    <form onSubmit={(e)=>onAdd(e)}>
                        <div className="mb-3">
                            <label htmlFor="Name" className="form-label">
                                Name
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's name"
                                name="pokemonName"
                                value={pokemonName}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Type" className="form-label">
                                Type
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's type"
                                name="type"
                                value={type}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Level" className="form-label">
                                Level
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's level"
                                name="level"
                                value={level}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Hitpoints" className="form-label">
                                Hitpoints
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's hitpoints"
                                name="hp"
                                value={hp}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Attack" className="form-label">
                                Attack
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's attack"
                                name="attack"
                                value={attack}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Defense" className="form-label">
                                Defense
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter the pokemon's defense"
                                name="defense"
                                value={defense}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <button type="submit" className="btn btn-outline-primary px-3">Edit</button>
                        <Link type="submit" className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    )
}
